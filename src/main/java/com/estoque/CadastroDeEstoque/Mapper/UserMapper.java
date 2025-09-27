package com.estoque.CadastroDeEstoque.Mapper;

import com.estoque.CadastroDeEstoque.Model.User;
import com.estoque.CadastroDeEstoque.DTO.UserRequest;
import com.estoque.CadastroDeEstoque.DTO.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .nome(request.nome())
                .usuario(request.usuario())
                .senha(request.senha())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .nome(user.getNome())
                .usuario(user.getUsuario())
                .build();
    }

}
