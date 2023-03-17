package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog


        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
        blog.getImageList().add(image);

        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {

        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=new Image();
        try {
            image = imageRepository2.findById(id).get();
        }catch(Exception e){
            throw new RuntimeException(e.toString());
        }
        int screenDim=(screenDimensions.charAt(0)-'0')*(screenDimensions.charAt(2)-'0');
        int imageScreenDim=(image.getDimensions().charAt(0)-'0')*(image.getDimensions().charAt(2)-'0');
        int count=0;
        try {
            count=screenDim/imageScreenDim;
        }catch(ArithmeticException e){
            throw new RuntimeException(e.toString());
        }
        return count;
    }
}
