package com.estoque.CadastroDeEstoque.Usuario;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static  User toUser(UserRequest request){
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
