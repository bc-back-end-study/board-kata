package com.kata.boardkata.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"header", "body"})
public class BaseResponse<T> {
    private Header header = new Header();
    private T body;

    public BaseResponse(T body) {
        setHeaderWithBaseStatusCode(BaseStatusCode.SUCCESS);
        this.body = body;
    }
    public BaseResponse(BaseStatusCode statusCode, T body) {
        setHeaderWithBaseStatusCode(statusCode);
        this.body = body;
    }

    public BaseResponse(BaseStatusCode statusCode, String message, T body) {
        setHeaderWithBaseStatusCodeAndMessage(statusCode, message);
        this.body = body;
    }

    public BaseResponse(int status, String message) {
        setHeaderWithStatusAndMessage(status, message);
    }

    public BaseResponse(int status, String message, T body) {
        setHeaderWithStatusAndMessage(status, message);
        this.body = body;
    }

    private void setHeaderWithBaseStatusCode(BaseStatusCode statusCode) {
        this.header.setStatus(statusCode.getStatus());
        this.header.setMessage(statusCode.getMessage());
    }

    private void setHeaderWithBaseStatusCodeAndMessage(BaseStatusCode statusCode, String message) {
        this.header.setStatus(statusCode.getStatus());
        this.header.setMessage(message);
    }

    private void setHeaderWithStatusAndMessage(int status, String message) {
        this.header.setStatus(status);
        this.header.setMessage(message);
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @JsonPropertyOrder({"status", "message"})
    public static class Header {
        private int status;
        private String message;

        public Header() {
            this.status = BaseStatusCode.SUCCESS.getStatus();
            this.message = BaseStatusCode.SUCCESS.getMessage();
        }
    }
}