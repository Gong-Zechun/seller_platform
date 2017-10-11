package com.util.mybatis;
import org.mybatis.generator.api.IntrospectedTable;  
import org.mybatis.generator.api.PluginAdapter;  
import org.mybatis.generator.api.dom.java.*;  
  
import java.util.List;  
import java.util.Properties;  

/**
 * 类功能描述:添加分页父类及序列化接口
 * @className SuperClassAndInterfacePlugin.java
 * 
 * @author Allen Gong
 * @version 1.0
 * 
 * @history 2017-01-01 Allen Gong 创建 SuperClassAndInterfacePlugin.java
 */
public class SuperClassAndInterfacePlugin extends PluginAdapter{
	private FullyQualifiedJavaType abstractPageEntity;  
    private FullyQualifiedJavaType serializable;  
    private FullyQualifiedJavaType gwtSerializable;  
    private boolean addGWTInterface;  
    private boolean suppressJavaInterface;  
  
    public SuperClassAndInterfacePlugin() {  
        super();  
        abstractPageEntity = new FullyQualifiedJavaType("com.seller.page.AbstractPageEntity"); //$NON-NLS-1$
        serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$  
        gwtSerializable = new FullyQualifiedJavaType("com.google.gwt.user.client.rpc.IsSerializable"); //$NON-NLS-1$  
    }  
  
    public boolean validate(List<String> warnings) {  
        // this plugin is always valid  
        return true;  
    }  
  
    @Override  
    public void setProperties(Properties properties) {  
        super.setProperties(properties);  
        addGWTInterface = Boolean.valueOf(properties.getProperty("addGWTInterface")); //$NON-NLS-1$  
        suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); //$NON-NLS-1$  
    }  
  
    @Override  
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,  
                                                 IntrospectedTable introspectedTable) {  
        makeSerializable(topLevelClass, introspectedTable, true);  
        return true;  
    }  
  
    @Override  
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,  
                                                 IntrospectedTable introspectedTable) {  
        makeSerializable(topLevelClass, introspectedTable, true);  
        return true;  
    }  
  
    @Override  
    public boolean modelRecordWithBLOBsClassGenerated(  
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        makeSerializable(topLevelClass, introspectedTable, true);  
        return true;  
    }  
  
    /** 
     * 添加给Example类序列化的方法 
     * @param topLevelClass 
     * @param introspectedTable 
     * @return 
     */  
    @Override  
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable){  
        makeSerializable(topLevelClass, introspectedTable, false);  
  
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
        	Field serialVersionUIDField = this.getSerialField();
            if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$  
                innerClass.addSuperInterface(serializable); 
                innerClass.addField(serialVersionUIDField);
            }  
            if ("Criteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$  
                innerClass.addSuperInterface(serializable);  
                innerClass.addField(serialVersionUIDField);
            }  
            if ("Criterion".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$  
                innerClass.addSuperInterface(serializable); 
                innerClass.addField(serialVersionUIDField);
            }  
        }  
  
        return true;  
    }  
  
    protected void makeSerializable(TopLevelClass topLevelClass,  
                                    IntrospectedTable introspectedTable, boolean isModel) {  
        if (addGWTInterface) { 
        	if(isModel){
        		topLevelClass.setSuperClass(abstractPageEntity);
        	}
            topLevelClass.addImportedType(gwtSerializable);  
            topLevelClass.addSuperInterface(gwtSerializable);  
        }  
  
        if (!suppressJavaInterface) {
        	if(isModel){
        		topLevelClass.setSuperClass(abstractPageEntity);
        	}
            topLevelClass.addImportedType(serializable);  
            topLevelClass.addSuperInterface(serializable);  
  
            Field serialVersionUIDField = this.getSerialField();
            context.getCommentGenerator().addFieldComment(serialVersionUIDField, introspectedTable);  
            topLevelClass.addField(serialVersionUIDField);  
        }  
    }
    /**
     * 获取序列化版本号域
     * @return
     */
    private Field getSerialField(){
    	 Field field = new Field();  
         field.setFinal(true);  
         field.setInitializationString("1L"); //$NON-NLS-1$  
         field.setName("serialVersionUID"); //$NON-NLS-1$  
         field.setStatic(true);  
         field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$  
         field.setVisibility(JavaVisibility.PRIVATE);
         return field;
    }
}
