package com.show.demo.Models;

import com.show.demo.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Showseat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer seatNo;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean isAvailable;
    private boolean isFoodAttached;


}
