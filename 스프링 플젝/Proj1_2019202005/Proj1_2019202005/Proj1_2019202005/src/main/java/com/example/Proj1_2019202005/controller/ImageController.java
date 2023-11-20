package com.example.Proj1_2019202005.controller;

import com.example.Proj1_2019202005.domain.Image;
import com.example.Proj1_2019202005.domain.ImageDTO;
import com.example.Proj1_2019202005.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Proj1_2019202005.service.ImageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"", "/", "/index.html"})
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepo imageRepo;

    @GetMapping("upload") //GET API 매핑
    public String create(Model model){
        model.addAttribute("image", new Image()); // 데이터 전달
        return "upload"; //upload.html 반환
    }

    @PostMapping("/upload") //POST API 매핑
    public String createBoard(@ModelAttribute("image") Image image, @RequestParam("file") MultipartFile file) throws Exception {
        imageService.createImage(image, file);
        return "redirect:/"; //index.html로 리다이렉션
    }

    @GetMapping(path = "imageview/upload/{id}") //GET API 매핑
    public String viewerUpdate(Model model, @PathVariable Long id) {
        Optional<Image> image = imageRepo.findById(id); //ID로 데이터 조회
        model.addAttribute("image", image.get()); //데이터 전달
        return "upload"; //upload.html 반환
    }

    @PostMapping("/imageview/upload/{id}")
    public String updateImage(@PathVariable("id") Long id, @ModelAttribute("image") ImageDTO imageDTO, @RequestParam("file") MultipartFile file) throws Exception {
        imageService.updateImage(id, imageDTO, file);
        return "redirect:/"; //index.html로 리다이렉션
    }

    @PutMapping("image/{id}") //PUT API 매핑
    public RedirectView updateImage(@PathVariable Long id,@ModelAttribute("image") ImageDTO imageDTO){ // 게시물 수정
        try {
            Optional<Image> updateImage = imageRepo.findById(id); //ID로 데이터 조회
            Image image1 = updateImage.get(); //조회된 데이터 가져오기
            image1.setContents(imageDTO.getContents()); //수정된 내용으로 게시물 내용 설정
            image1.setTitle(imageDTO.getTitle()); //수정된 내용으로 게시물 제목 설정
            imageRepo.save(image1); //게시물 저장
        } catch (Exception e){ //예외 처리
            e.printStackTrace();
        }
        return new RedirectView("/");//index.html로 리다이렉션
    }

    @GetMapping //GET API 매핑
    public String page(Model model) {
        List<Image> imageList = imageRepo.findAll();
        model.addAttribute("imageList", imageList);
        return "index"; //index.html 반환
    }


    @GetMapping(path = "imageview/{id}") //GET API 매핑
    public String viewer(Model model, @PathVariable Long id){
        Optional<Image> image = imageRepo.findById(id); //ID로 데이터 조회
        Image imageEntity = image.get(); //가져온 데이터
        Image imageAfterSave = imageRepo.save(imageEntity);
        model.addAttribute("image", imageAfterSave); //데이터 전달
        return "imageview"; //imageview.html 반환
    }

    @PostMapping(path = "imageview/{id}") //POST API 매핑
    public String remove(@PathVariable("id") Long id){
        imageService.deleteImage(id); //ID로 데이터 삭제
        return "redirect:/"; //index.html로 리다이렉션
    }
}