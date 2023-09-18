package com.example.kyo.post.comment.definition;

import java.util.Date;
import java.util.List;

import com.example.kyo.post.definition.PostModel;
import com.example.kyo.post.like.definition.LikeModel;
import com.example.kyo.user.definition.UserModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class CommentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "posts_id")
	private PostModel posts;

	@OneToMany(mappedBy = "comments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LikeModel> like;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
}
