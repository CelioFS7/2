package repositorio

import entity.ContatoEntity

class ContactRepositorio {

    companion object {
        private val contaclist = mutableListOf<ContatoEntity>()

        fun save(contact: ContatoEntity) {
            contaclist.add(contact)


        }

        fun delete(contact: ContatoEntity) {
            // contaclist.remove(contact)

            var index = 0
            for (item in contaclist.withIndex()) {
                if (item.value.name == contact.name && item.value.fone == contact.fone) {
                    index = item.index
                    break
                }

            }
            contaclist.removeAt(index)
        }

        fun getList(): List<ContatoEntity> {
            return contaclist


        }
    }
}