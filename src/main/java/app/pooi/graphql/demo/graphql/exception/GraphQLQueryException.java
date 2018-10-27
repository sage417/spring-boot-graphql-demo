package app.pooi.graphql.demo.graphql.exception;

import graphql.GraphQLError;
import lombok.Getter;

import java.util.List;

@Getter
public class GraphQLQueryException extends RuntimeException {

    private final List<GraphQLError> errors;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public GraphQLQueryException(List<GraphQLError> errors) {
        this.errors = errors;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public GraphQLQueryException(String message, List<GraphQLError> errors) {
        super(message);
        this.errors = errors;
    }


}
