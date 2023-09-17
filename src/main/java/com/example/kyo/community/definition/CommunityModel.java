package com.example.kyo.community.definition;

import java.util.Date;
import java.util.List;

import com.example.kyo.community.topic.definition.TopicModel;
import com.example.kyo.community.visibility.enumeration.VisibilityEnum;
import com.example.kyo.post.definition.PostModel;
import com.example.kyo.user.definition.UserModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "community")
public class CommunityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(length = 1000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@ManyToMany
	@JoinTable(name = "community_user", joinColumns = @JoinColumn(name = "community_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<UserModel> members;

	@ManyToMany
	@JoinTable(name = "community_admin", joinColumns = @JoinColumn(name = "community_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<UserModel> admins;

	@ManyToMany(mappedBy = "communities")
	private List<TopicModel> topics;

	@Column(name = "visibility")
	private VisibilityEnum visibility;

	@ManyToMany
	@JoinTable(name = "community_post", joinColumns = @JoinColumn(name = "community_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
	private List<PostModel> posts;
}
