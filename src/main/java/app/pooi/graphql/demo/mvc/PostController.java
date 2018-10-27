package app.pooi.graphql.demo.mvc;

import app.pooi.graphql.demo.graphql.exception.GraphQLQueryException;
import com.google.common.collect.ImmutableMap;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.servlet.DefaultGraphQLErrorHandler;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {

    private GraphQLErrorHandler errorHandler = new DefaultGraphQLErrorHandler();

    private GraphQLSchema graphQLSchema;

    public PostController(GraphQLSchema graphQLSchema) {
        this.graphQLSchema = graphQLSchema;
    }

    @GetMapping("/queryRecentPosts")
    public Map<String, Object> queryRecentPosts(Integer count, Integer offset) {
        final ExecutionResult result = GraphQL.newGraphQL(graphQLSchema).build()
                .execute(ExecutionInput.newExecutionInput()
                        .query("query ($count: Int, $offset: Int){recentPosts(count: $count, offset: $offset) {id title category author {id name thumbnail }}}")
                        .variables(ImmutableMap.of("count", count, "offset", offset))
                        .build());
        if (!CollectionUtils.isEmpty(result.getErrors())) {
            throw new GraphQLQueryException(result.getErrors());
        }
        return result.getData();
    }

    @ExceptionHandler(GraphQLQueryException.class)
    Map<String, Object> handleGraphQLQueryException(GraphQLQueryException e) {
        final Map<String, Object> result = new HashMap<>();

        if (errorHandler.errorsPresent(e.getErrors())) {
            result.put("errors", errorHandler.processErrors(e.getErrors()));
        }

        return result;
    }

}
