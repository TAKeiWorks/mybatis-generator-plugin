package net.takeiworks.mybatis.generator.plugin;

import net.takeiworks.mybatis.supports.core.annotation.UpdateByPrimaryKey;
import net.takeiworks.mybatis.supports.core.annotation.UpdateByPrimaryKeySelective;
import net.takeiworks.mybatis.supports.core.annotation.UpdateByExample;
import net.takeiworks.mybatis.supports.core.annotation.UpdateByExampleSelective;

import java.lang.annotation.Annotation;

import net.takeiworks.mybatis.supports.core.annotation.DeleteByPrimaryKey;
import net.takeiworks.mybatis.supports.core.annotation.DeleteByExample;
import net.takeiworks.mybatis.supports.core.annotation.Insert;
import net.takeiworks.mybatis.supports.core.annotation.InsertSelective;
import net.takeiworks.mybatis.supports.core.annotation.SelectByPrimaryKey;
import net.takeiworks.mybatis.supports.core.annotation.SelectByExample;
import net.takeiworks.mybatis.supports.core.annotation.CountByExample;

/**
 * 
 * メソッド名とアノテーションのマッピングを示す列挙型。<br>
 * 
 * @author TAKeiWorks
 */
public enum MethodMapping {
    /** {@link DeleteByPrimaryKey} */
    DELETE_BY_PRIMARY_KEY("getDeleteByPrimaryKeyStatementId", DeleteByPrimaryKey.class)
    /** {@link DeleteByExample} */
    ,DELETE_BY_EXAMPLE("getDeleteByExampleStatementId", DeleteByExample.class)
    /** {@link UpdateByPrimaryKey} */
    ,UPDATE_BY_PRIMARY_KEY("getUpdateByPrimaryKeyStatementId", UpdateByPrimaryKey.class)
    /** {@link UpdateByPrimaryKeySelective} */
    ,UPDATE_BY_PRIMARY_KEY_SELECTIVE("getUpdateByPrimaryKeySelectiveStatementId", UpdateByPrimaryKeySelective.class)
    /** {@link UpdateByExample} */
    ,UPDATE_BY_EXAMPLE("getUpdateByExampleStatementId", UpdateByExample.class)
    /** {@link UpdateByExampleSelective} */
    ,UPDATE_BY_EXAMPLE_SELECTIVE("getUpdateByExampleSelectiveStatementId", UpdateByExampleSelective.class)
    /** {@link SelectByPrimaryKey} */
    ,SELECT_BY_PRIMARY_KEY("getSelectByPrimaryKeyStatementId", SelectByPrimaryKey.class)
    /** {@link SelectByExample} */
    ,SELECT_BY_EXAMPLE("getSelectByExampleStatementId", SelectByExample.class)
    /** {@link CountByExample} */
    ,COUNT_BY_EXAMPLE("getCountByExampleStatementId", CountByExample.class)
    /** {@link Insert} */
    ,INSERT("getInsertStatementId", Insert.class)
    /** {@link InsertSelective} */
    ,INSERT_SELECTIVE("getInsertSelectiveStatementId", InsertSelective.class);

    /** メソッド名 */
    private String methodName;

    /** アノテーションのクラス */
    private Class<? extends Annotation> annotationClass;

    /**
     * 
     * {@link MethodMapping}のインスタンスを生成する。<br>
     * 
     * @param methodName      メソッド名
     * @param annotationClass アノテーションのクラス
     */
    private MethodMapping(String methodName, Class<? extends Annotation> annotationClass) {
        this.methodName = methodName;
        this.annotationClass = annotationClass;
    }

    /**
     * 
     * メソッド名を返す。<br>
     * 
     * @return メソッド名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 
     * アノテーションのクラスを返す。<br>
     * 
     * @return アノテーションのクラス
     */
    public Class<? extends Annotation> getAnnotationClass() {
        return annotationClass;
    }
}