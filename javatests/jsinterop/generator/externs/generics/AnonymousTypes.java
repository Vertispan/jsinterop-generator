package jsinterop.generator.externs.generics;

import java.lang.Object;
import java.lang.String;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AnonymousTypes<T> {
  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface BarFooType<T> {
    @JsOverlay
    static AnonymousTypes.BarFooType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    T getBar();

    @JsProperty
    void setBar(T bar);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface FooFooType<V, U, T> {
    @JsOverlay
    static AnonymousTypes.FooFooType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    U getBar();

    @JsProperty
    T getBaz();

    @JsProperty
    V getFoo();

    @JsProperty
    void setBar(U bar);

    @JsProperty
    void setBaz(T baz);

    @JsProperty
    void setFoo(V foo);
  }

  @JsFunction
  public interface FunctionTypeWithGenericInParameterFooCallbackFn<T> {
    boolean onInvoke(T p0);
  }

  @JsFunction
  public interface FunctionTypeWithGenericInReturnTypeFooFn<T> {
    T onInvoke(boolean p0);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface TypeLiteralFooType<T> {
    @JsOverlay
    static AnonymousTypes.TypeLiteralFooType create() {
      return Js.uncheckedCast(JsPropertyMap.of());
    }

    @JsProperty
    T getBar();

    @JsProperty
    T getFoo();

    @JsProperty
    void setBar(T bar);

    @JsProperty
    void setFoo(T foo);
  }

  @JsType(isNative = true, name = "?", namespace = JsPackage.GLOBAL)
  public interface UnionTypeFooUnionType<T> {
    @JsOverlay
    static AnonymousTypes.UnionTypeFooUnionType of(Object o) {
      return Js.cast(o);
    }

    @JsOverlay
    default String asString() {
      return Js.asString(this);
    }

    @JsOverlay
    default T asT() {
      return Js.cast(this);
    }

    @JsOverlay
    default boolean isString() {
      return (Object) this instanceof String;
    }
  }

  public static native <T> void bar(AnonymousTypes.BarFooType<T> foo);

  public native <V, U> void foo(AnonymousTypes.FooFooType<V, U, T> foo);

  public native void functionTypeWithGenericInParameter(
      AnonymousTypes.FunctionTypeWithGenericInParameterFooCallbackFn<? super T> fooCallback);

  public native void functionTypeWithGenericInReturnType(
      AnonymousTypes.FunctionTypeWithGenericInReturnTypeFooFn<? extends T> foo);

  public native void typeLiteral(AnonymousTypes.TypeLiteralFooType<T> foo);

  @JsOverlay
  public final void unionType(String foo) {
    unionType(Js.<AnonymousTypes.UnionTypeFooUnionType<T>>uncheckedCast(foo));
  }

  @JsOverlay
  public final void unionType(T foo) {
    unionType(Js.<AnonymousTypes.UnionTypeFooUnionType<T>>uncheckedCast(foo));
  }

  public native void unionType(AnonymousTypes.UnionTypeFooUnionType<T> foo);
}
