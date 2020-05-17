package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/default")
public interface AbstractController<T> {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody T t);

    @PutMapping(value = "/update",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    T update(T t, @RequestParam("id") String id);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> getAll();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    T getById(@PathVariable("id") final String id);
}
