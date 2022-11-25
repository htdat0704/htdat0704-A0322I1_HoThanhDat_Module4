package baitap.blog.controller.restful;

import baitap.blog.model.Blog;
import baitap.blog.model.Category;
import baitap.blog.service.IBlogService;
import baitap.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestfulController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categoryList")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categoryList =  iCategoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Blog>> findAllBlogByCategory(@PathVariable String name){
        Optional<Category> category = iCategoryService.findByName(name);
        if(category.isPresent()){
            List<Blog> blogs = iBlogService.findByCategory(category.get().getId());
            if (blogs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> blogs = (List<Blog>) iBlogService.findALl();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> detailBlob(@PathVariable int id){
        Optional<Blog> blog = iBlogService.findById(id);
        if(blog.isPresent()){
            return new ResponseEntity<>(blog.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/search")
    public ResponseEntity<Iterable<Blog>> listBlog(@RequestBody String searchValue){
        String[] search = searchValue.split("=");
        return new ResponseEntity<>(iBlogService.findByAuthorContaining(search[1]),HttpStatus.OK);
    }
}
