package com.softwarefoundations.blogger.services;

import com.softwarefoundations.blogger.entity.PostEntity;
import com.softwarefoundations.blogger.entity.dto.PostDto;
import com.softwarefoundations.blogger.repository.PostRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PostService extends AbstractService {

    private PostRespository postRespository;

    @Autowired
    public PostService(PostRespository postRespository) {
        this.postRespository = postRespository;
    }

    public PostDto cadastrarPost(PostDto postDto){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitulo(postDto.getTitulo());
        postEntity.setTexto(postDto.getTexto());
        postRespository.save(postEntity);
        return postDto;
    }

    public Page<PostDto> listarPosts(Pageable paginacao){
        return postRespository.findAll(paginacao).map(PostEntity::toDto);
    }

}
