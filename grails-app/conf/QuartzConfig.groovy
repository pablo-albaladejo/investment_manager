/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
quartz {
    autoStartup = true
    jdbcStore = false
}
environments {
    test {
        quartz {
            autoStartup = true
        }
    }
}

