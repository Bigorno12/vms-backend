package com.pacdesign.service.dto;

import com.pacdesign.persistence.enumeration.Gender;
import lombok.Builder;

@Builder
public record UserDto(String firstName, Gender gender) {
}
