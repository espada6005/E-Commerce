package com.dailycodework.buynowdotcom.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dailycodework.buynowdotcom.dtos.ImageDto;
import com.dailycodework.buynowdotcom.model.Image;

public interface ImageService {

    Image getImageById(Long imageId);

    void deleteImageById(Long imageId);

    void updateImage(MultipartFile file, Long imageId);

    List<ImageDto> savImages(Long productId, List<MultipartFile> files);

}
