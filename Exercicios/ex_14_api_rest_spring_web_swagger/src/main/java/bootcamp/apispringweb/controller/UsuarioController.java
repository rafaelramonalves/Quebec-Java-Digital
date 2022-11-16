package bootcamp.apispringweb.controller;

import bootcamp.apispringweb.model.Usuario;
import bootcamp.apispringweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/users")
    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }

    @GetMapping("/users/{userName}")
    public Usuario gerOne(@PathVariable("userName") String userName){
        return repository.findByUsername(userName);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}
