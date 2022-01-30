package com.Store.openLegacyStore.Beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Supplier")
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
}
