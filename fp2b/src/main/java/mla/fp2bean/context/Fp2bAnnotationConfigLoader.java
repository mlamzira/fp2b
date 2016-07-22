package mla.fp2bean.context;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

import mla.fp2bean.annotations.FieldElement;
import mla.fp2bean.annotations.FieldRoot;
import mla.fp2bean.annotations.Fp2bRootTemplate;
import mla.fp2bean.annotations.Replace;
import mla.fp2bean.descriptor.Fp2bFieldElement;
import mla.fp2bean.descriptor.Fp2bReplace;
import mla.fp2bean.descriptor.Fp2bRootElement;
import mla.fp2bean.exception.Fp2bException;
import mla.fp2bean.parser.Parser;

public class Fp2bAnnotationConfigLoader {
	
	
	public static <T> Fp2bEngine<T> loadConfig(Class<T> annotatedClass) throws Fp2bException{
		
		if(annotatedClass.isAnnotationPresent(Fp2bRootTemplate.class)){
			
			Map<Integer, Fp2bFieldElement> treeFields = new TreeMap<Integer, Fp2bFieldElement>();
			Fp2bRootElement root = createRootElement(annotatedClass);
			
			for(Field field : annotatedClass.getDeclaredFields()){
				
				if(field.isAnnotationPresent(FieldRoot.class)){
					loadFieldConfigForMultiplePositions(field, root, treeFields);
					
				} else if(field.isAnnotationPresent(FieldElement.class)){
					loadFieldConfig(field, root, treeFields);

				}
			}
			
			if(!treeFields.isEmpty()){
				for(Integer index : treeFields.keySet()){
					Fp2bFieldElement element = treeFields.get(index);
					root.add(element);
				}
			} else {
				throw new Fp2bException("at least one field should be annotated");
			}
			

			
			return Fp2bFactory.createFP2BeanEngine(root);
			
		} else {
			throw new Fp2bException("provided class ["+
					annotatedClass.getName()+"]is not annotated, stick to the rules !");
		}
		
	}
	
	private static <T> Fp2bRootElement createRootElement(Class<T> annotatedClass){
		Fp2bRootElement root = new Fp2bRootElement();
		Fp2bRootTemplate rootAnnotation = annotatedClass.getAnnotation(Fp2bRootTemplate.class);
		
		root.setName(rootAnnotation.name());
		root.setType(annotatedClass.getName());
		root.setClazz(annotatedClass);
		
		return root;
	}
	
	private static void loadFieldConfigForMultiplePositions(Field field,Fp2bRootElement root, Map<Integer, Fp2bFieldElement> treeFields) throws Fp2bException{
		FieldRoot fieldRootAnnotation = field.getAnnotation(FieldRoot.class);
		
		for(FieldElement fieldAnnotation : fieldRootAnnotation.multiplePositions()){
			
			loadElementaryFieldConfig(field, root, treeFields, fieldAnnotation);
		}
	}
	
	private static void loadFieldConfig(Field field,Fp2bRootElement root, Map<Integer, Fp2bFieldElement> treeFields) throws Fp2bException{
		
		FieldElement fieldAnnotation = field.getAnnotation(FieldElement.class);
		loadElementaryFieldConfig(field, root, treeFields, fieldAnnotation);
		
	}
	
	private static void loadElementaryFieldConfig(Field field,
			Fp2bRootElement root,
			Map<Integer,
			Fp2bFieldElement> treeFields,
			FieldElement fieldAnnotation) throws Fp2bException{
		
		Fp2bFieldElement element = createElement(fieldAnnotation);
		element.setParent(root);
		element.setType(field.getType().getName());
		element.setClazz(field.getType());
		
		element.setName(fieldAnnotation.name().equals("")?field.getName():fieldAnnotation.name());
		
		if(!treeFields.containsKey(fieldAnnotation.index())){
			
			treeFields.put(fieldAnnotation.index(), element);
			
		} else {
			throw new Fp2bException("two fields have the same index");
		}
	}
	
	private static Fp2bFieldElement createElement(FieldElement fieldAnnotation){
		Fp2bFieldElement fieldElement = new Fp2bFieldElement();
		
		
		fieldElement.setLength(fieldAnnotation.length());
		fieldElement.setPrefix(fieldAnnotation.prefix());
		fieldElement.setSuffix(fieldAnnotation.suffix());
		fieldElement.setRequired(fieldAnnotation.required());
		fieldElement.setParser(fieldAnnotation.parser().equals(Parser.class)?
						null:fieldAnnotation.parser().getName());
		fieldElement.setDatePattern(fieldAnnotation.datePattern());
		
		if(fieldAnnotation.replacements().length>0){
			for(Replace replaceAnnotation : fieldAnnotation.replacements()){
				Fp2bReplace replace = new Fp2bReplace();
				replace.setOldChar(replaceAnnotation.oldChar()+"");
				replace.setNewChar(replaceAnnotation.newChar()+"");
				replace.setWhen(replaceAnnotation.when());
				
				fieldElement.getReplacements().add(replace);
			}
		}
		
		return fieldElement;
	}

}
