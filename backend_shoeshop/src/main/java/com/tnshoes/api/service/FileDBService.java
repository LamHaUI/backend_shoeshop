package com.tnshoes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tnshoes.api.entity.FileDB;
import com.tnshoes.api.repository.FileDBRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileDBService {

	@Autowired
    private FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB image = new FileDB(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(image);
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
    
    public Optional<FileDB> getFileById(String id) {
        return fileDBRepository.findById(id);

    }
}
