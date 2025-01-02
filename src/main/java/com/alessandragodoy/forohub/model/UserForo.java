package com.alessandragodoy.forohub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_foro")
@Entity
public class UserForo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String name;

	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank
	@Size(min = 8)
	private String password;

	@Enumerated(value = EnumType.STRING)
	@NotNull
	private UserRole role;
}
