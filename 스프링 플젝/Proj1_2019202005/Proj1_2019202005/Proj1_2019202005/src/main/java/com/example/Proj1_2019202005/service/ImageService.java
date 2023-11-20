package com.example.Proj1_2019202005.service;

import com.example.Proj1_2019202005.domain.Image;
import com.example.Proj1_2019202005.domain.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proj1_2019202005.repository.ImageRepo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {
    @Autowired
    private ImageRepo imageRepo;

    public void createImage(Image image, MultipartFile file) throws Exception {
        //이미지 저장할 경로
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static";

        //UUID를 사용하여 파일 이름 생성
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();

        //파일을 저장할 경로 생성
        File saveFile = new File(projectPath, fileName);

        //업로드된 파일을 저장 경로로 전송하여 저장
        file.transferTo(saveFile);

        //Image 객체에 파일 이름과 경로 설정
        image.setFilename(fileName);
        image.setFilepath(fileName);

        //Image 객체를 데이터베이스에 저장
        imageRepo.save(image);
    }

    //삭제 기능
    public void deleteImage(Long id) {
        imageRepo.deleteById(id);
    }

    public void updateImage(Long id, ImageDTO imageDTO, MultipartFile file) throws Exception {
        Optional<Image> optionalImage = imageRepo.findById(id);
        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();

            //ImageDTO의 새로운 값으로 이미지 필드를 수정
            image.setTitle(imageDTO.getTitle());
            image.setContents(imageDTO.getContents());

            //새로운 이미지 파일을 저장
            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static";
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);
            file.transferTo(saveFile);
            image.setFilename(fileName);
            image.setFilepath(fileName);

            //업데이트된 이미지 엔티티 저장
            imageRepo.save(image);
        }
    }
}
