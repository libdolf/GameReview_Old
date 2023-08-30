package br.com.libdolf.gamereview.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Long id;
    private String name;
    private List<Integer> platforms ;
    private List<Integer> genres;
    private Integer rating;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platforms=" + platforms +
                ", genres=" + genres +
                ", rating=" + rating +
                '}';
    }
}
