package com.example.kyo.community.topic.definition;

import java.util.List;

import com.example.kyo.community.definition.CommunityModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
@EqualsAndHashCode(callSuper = false)
public class TopicModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "community_topic", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "community_id"))
	private List<CommunityModel> communities;
}
