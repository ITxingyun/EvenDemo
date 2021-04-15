package com.xingyun.apt.processor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.xingyun.apt.annotation.EMapper;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class EMapperProcessor extends AbstractProcessor {

	private Messager mMessager;
	private Elements mElementUtils;
	private Filer mFiler;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnvironment) {
		super.init(processingEnvironment);
		//processingEnvironment里面有很多有用的工具类
		mMessager = processingEnv.getMessager();
		mElementUtils = processingEnv.getElementUtils();
		mFiler = processingEnv.getFiler();
		mMessager.printMessage(Diagnostic.Kind.NOTE, "EMapperProcessor init...");
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		HashSet<String> supportTypes = new HashSet<>();
		supportTypes.add(EMapper.class.getCanonicalName());
		return supportTypes;
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		//指定使用的Java版本
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
		mMessager.printMessage(Diagnostic.Kind.NOTE, "EMapperProcessor processing...");
		//得到所有的注解
		Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(EMapper.class);

		for (Element element : elements) {
			generateMapperFile("fullClassName");
		}

		return true;
	}

	private void generateMapperFile(String fullClassName) {

		MethodSpec main = MethodSpec.methodBuilder("main")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(void.class)
				.addParameter(String[].class, "args")
				.addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
				.build();

		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addMethod(main)
				.build();
		try {
			JavaFile.builder("com.xingyun.apt.library", helloWorld)
					.build().writeTo(mFiler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
