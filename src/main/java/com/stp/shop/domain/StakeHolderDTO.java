package com.stp.shop.domain;

import lombok.*;

import java.util.Objects;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StakeHolderDTO {
    private long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeHolderDTO that = (StakeHolderDTO) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
