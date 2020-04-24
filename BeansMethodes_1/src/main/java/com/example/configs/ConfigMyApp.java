/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package com.example.configs;

import com.example.LanceurDeTache;
import com.example.Tache;
import java.util.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
@Configuration
public class ConfigMyApp {

    @Bean
    public LanceurDeTache lanceurTaches(Collection<Tache> taches) {
        return new LanceurDeTache(taches);
    }
}
