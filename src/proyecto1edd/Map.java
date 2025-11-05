/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author biancazullo
 */
public class Map<K, V> {
    private List<K> keys;
    private List<V> values;
    
    public Map() {
        this.keys = new List<K>();
        this.values = new List<V>();
    }
    
    public void insert(K key, V value) {
        int idx = this.keys.getIdxOf(key);
        if(idx == -1) {
            this.keys.insert(key);
            this.values.insert(value);
        } else {
            this.values.set(idx, value);
        }
    }
    
    public V get(K key) {
        int idx = this.keys.getIdxOf(key);
        if(idx == -1)
            return null;
        
        return this.values.get(idx);
    }
}
