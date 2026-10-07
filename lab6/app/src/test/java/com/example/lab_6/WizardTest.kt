package com.example.lab_6

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class WizardTest {
    private lateinit var evilWizard: Wizard

    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt)

        assertEquals(20, evilWizard.mana)
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, evilWizard.mana)
    }

    // Participation
    @Test
    fun castSpell_frostbite_successful() {
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(20, damageDealt) //spellPower of 10 * 2
        assertEquals(25, evilWizard.mana) // mana of 30 - 5
    }

    @Test
    fun castSpell_frostbite_unsuccessful() {
        evilWizard.mana = 2  // Evil Wizard does not have enough mana to cast "Frostbite"
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(0, damageDealt)

        assertEquals(2, evilWizard.mana)
    }
}