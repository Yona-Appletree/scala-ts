package com.mpc.scalats.core

object TypeScriptModel {

  sealed trait Declaration

  sealed trait TypeRef

  case object NumberRef extends TypeRef

  case object StringRef extends TypeRef

  case class InterfaceRef(name: String) extends TypeRef

  case class ArrayRef(innerType: TypeRef) extends TypeRef

  case object DateRef extends TypeRef

  case object DateTimeRef extends TypeRef

  case class InterfaceDeclaration(name: String, members: List[Member]) extends Declaration

  case class Member(name: String, typeRef: TypeRef)

  case class ClassDeclaration(name: String, constructor: ClassConstructor) extends Declaration

  case class ClassConstructor(parameters: List[ClassConstructorParameter])

  case class ClassConstructorParameter(name: String,
                                       typeRef: TypeRef,
                                       accessModifier: Option[AccessModifier])

  sealed trait AccessModifier

  case object AccessModifier {

    case object Public extends AccessModifier

    case object Private extends AccessModifier

  }

}