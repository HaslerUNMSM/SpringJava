package com.udemy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QContacto is a Querydsl query type for Contacto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContacto extends EntityPathBase<Contacto> {

    private static final long serialVersionUID = 322607969L;

    public static final QContacto contacto = new QContacto("contacto");

    public final StringPath city = createString("city");

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath telephone = createString("telephone");

    public QContacto(String variable) {
        super(Contacto.class, forVariable(variable));
    }

    public QContacto(Path<? extends Contacto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContacto(PathMetadata metadata) {
        super(Contacto.class, metadata);
    }

}

