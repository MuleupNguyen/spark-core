package org.example;
import com.google.gson.Gson;

import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        post("/users", (request, response) -> {
           response.type("application/json");
           User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/users", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,new Gson()
                            .toJsonTree(userService.getUsers())));
        });

        get("/users/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,new Gson()
                            .toJsonTree(userService.getUser(request.params(":id")))));
        });
    }
}