package br.com.posts.endpoint.service;

import br.com.posts.endpoint.dto.PostSaveDTO;
import br.com.posts.endpoint.entity.Post;
import br.com.posts.endpoint.enums.PostStatusEnum;
import br.com.posts.endpoint.repository.PostRepository;
import br.com.posts.endpoint.service.impl.PostServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    public void savePostTest() {
        PostSaveDTO postSaveDTO = createSavePostDTO();
        Post post = createPostDTO();
        when(this.postRepository.save(post)).thenReturn(post);
        post = this.postService.savePost(postSaveDTO);
        Assert.assertNotNull(post);
    }

    private Post createPostDTO() {
        Post post = new Post();
        post.setId(1l);
        post.setStatus(PostStatusEnum.ACTIVE);
        post.setTitle("Test title");
        post.setDescription("Test Description");
        post.setDateInsert(LocalDateTime.now());
        return post;
    }

    private PostSaveDTO createSavePostDTO() {
        PostSaveDTO post = new PostSaveDTO();
        post.setTitle("Test title");
        post.setDescription("Test Description");
        return post;
    }

}
