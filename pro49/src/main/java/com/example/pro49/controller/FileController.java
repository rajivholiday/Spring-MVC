package com.example.pro49.controller;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
@Log4j2
public class FileController {

    @GetMapping
    public String handle_get() {
        return "pro49.html";
    }

    @PostMapping
    @ResponseBody
    @SneakyThrows
    public String handle_post(@RequestParam("filecontents") MultipartFile file) {
        byte[] bytes = file.getBytes();
        String contents = new String(bytes);
        log.info(contents);
        return String.format("file %s and its contents %s", file.getName(), contents);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> handle_download(@PathVariable String filename) {
        ClassPathResource resource = new ClassPathResource(filename);
        return ResponseEntity.ok(resource);

    }
}
