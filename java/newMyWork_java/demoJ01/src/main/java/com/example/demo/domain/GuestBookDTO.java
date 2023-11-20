package com.example.demo.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestBookDTO {
	
	private Long gno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate, modDate;
	
}
