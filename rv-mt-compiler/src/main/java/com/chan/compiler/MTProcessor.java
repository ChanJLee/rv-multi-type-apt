package com.chan.compiler;

import com.chan.annotations.Adapter;
import com.chan.annotations.Data;
import com.chan.annotations.Holder;
import com.google.auto.service.AutoService;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
public class MTProcessor extends AbstractProcessor {

    /**
	 * 用于写java文件
     */
    private Filer mFiler;
    /**
     * 可以理解为log
     */
    private Messager mMessager;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("hahah");

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {

        //添加支持的注解类型 我们支持JoinView
        Set<String> set = new HashSet<>();
        set.add(Data.class.getCanonicalName());
        set.add(Holder.class.getCanonicalName());
        set.add(Adapter.class.getCanonicalName());
        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_7;
    }
}