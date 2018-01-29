/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author device02
 */
@Component
public interface Emailable {
    String getEmail();
}
