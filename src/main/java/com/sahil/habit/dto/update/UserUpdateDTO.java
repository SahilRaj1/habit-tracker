package com.sahil.habit.dto.update;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDTO {

    @Builder.Default
    private Optional<String> phoneNumber = Optional.empty();

    @Builder.Default
    private Optional<String> username = Optional.empty();

    @Builder.Default
    private Optional<String> password = Optional.empty();
}
