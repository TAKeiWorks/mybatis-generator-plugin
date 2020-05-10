package net.takeiworks.mybatis.generator.plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;

/**
 * 
 * Mapperのメソッドにアノテーションを付与するプラグイン
 * 
 * @author TAKeiWorks
 */
public class GrantMethodAnnotationPlugin extends PluginAdapter {

    /**
     * @see org.mybatis.generator.api.Plugin#validate(List)
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * @see org.mybatis.generator.api.Plugin#clientGenerated(Interface,
     *      IntrospectedTable)
     */
    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {

        // メソッド名毎にメソッドを保持するマップ
        Map<String, Method> methods = new HashMap<>();
        interfaze.getMethods().forEach(method -> {
            methods.put(method.getName(), method);
        });

        for (MethodMapping mapping : MethodMapping.values()) {
            // enumに定義されているアノテーションをMapperの各メソッドに付与していく。
            try {
                String statementId = (String) IntrospectedTable.class.getMethod(mapping.getMethodName())
                        .invoke(introspectedTable);
                Method method = methods.get(statementId);
                if(method != null) {
                    // メソッドにアノテーションを追加
                    interfaze.addImportedType(new FullyQualifiedJavaType(mapping.getAnnotationClass().getCanonicalName()));
                    method.addAnnotation("@" + mapping.getAnnotationClass().getSimpleName());
                }
                
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException("statement id : [" + mapping.getMethodName() + "] can not find.", e);
            }
        }
        return true;
    }
}
