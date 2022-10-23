package com.example.cameit.global.error;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> customExceptionHandling(CustomException e) {
        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(
                CustomErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindExceptionHandling(BindException e) {
        Map<String, String> errorsList = new HashMap<>();
        for (FieldError error : e.getFieldErrors()) {
            errorsList.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }
}