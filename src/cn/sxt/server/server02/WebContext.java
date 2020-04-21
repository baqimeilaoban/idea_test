package cn.sxt.server.server02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
    private List<Entity> entities;
    private List<Mapping> mappings;

    /**
     * key-->servlet-name value-->servlet-class
     */
    private Map<String,String> entityMap = new HashMap<>();
    /**
     * key-->url-pattern value-->servlet-name
     */
    private Map<String,String> mappingMap = new HashMap<>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        //��entity��Listת���˶�Ӧ��map
        for (Entity entity:entities){
            entityMap.put(entity.getName(),entity.getClz());
        }

        //��map��Listת��Ϊ��Ӧ��map
        for (Mapping mapping:mappings){
            for (String pattern:mapping.getPatterns()){
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }

    /**
     * ͨ��URL��·���ҵ���Ӧ��class
     * @param pattern
     * @return
     */
    public String getClz(String pattern){
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}
