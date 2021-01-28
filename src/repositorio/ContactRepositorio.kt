package repositorio

import entity.ContatoEntity

class ContactRepositorio {

    companion object{
        private val contaclist = mutableListOf<ContatoEntity>()

    fun save (contact: ContatoEntity){
        contaclist.add(contact)


    }

    fun delete(contact: ContatoEntity){




        }
    }
}