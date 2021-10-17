package me.yourfavoritesde.kaliemailingservice.model;

public enum StatusCode {
    OK(200),
    NotFound(404),
    InternalServerError(500),
    ServiceUnavailable(503);
    private int id;
     StatusCode(int id){
        this.id=id;
    }
    public int getVal(){
        return id;
    }
}
