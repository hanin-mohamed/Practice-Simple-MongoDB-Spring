package com.mongo.springmogodb.controller;
import com.mongo.springmogodb.entity.Author;
import com.mongo.springmogodb.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authService;

    public AuthorController(AuthorService authService) {
        this.authService = authService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable  String id) {
        return ResponseEntity.ok(authService.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?>  findByEmail(String email) {
        return ResponseEntity.ok(authService.findByEmail(email));
    }
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody @Valid Author entity) {
        return ResponseEntity.ok(authService.insert(entity));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author entity) {
        return ResponseEntity.ok(authService.update(entity));
    }
    @PutMapping("/custom")
    public ResponseEntity<?>   updateByEmail(@RequestParam String email,@RequestParam String name,@RequestParam String phone){
        authService.updateByEmail(email,name,phone);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        authService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
//    @PostMapping("/spec")
//    public ResponseEntity<?> findByAutherSpec(@RequestBody AuthorSearch search) {
//        return ResponseEntity.ok(authService.findByAutherSpec(search));
//    }
}
