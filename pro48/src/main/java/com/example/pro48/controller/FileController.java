package com.example.pro48.controller;

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
    public String get() {
        return "new.html";
    }

    @PostMapping
    @ResponseBody
    @SneakyThrows
    public String handlePost(@RequestParam("contents") MultipartFile file) {
        byte[] bytes = file.getBytes();
        String fileContents = new String(bytes);
        log.info(fileContents);
        return String.format("File %s got. Contents: %s", file.getName(), fileContents);

    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        ClassPathResource resource = new ClassPathResource(filename);
        return ResponseEntity.ok(resource);
    }


}
