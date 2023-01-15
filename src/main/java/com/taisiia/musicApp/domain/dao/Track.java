package com.taisiia.musicApp.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String performer;
    private LocalTime duration;



}
