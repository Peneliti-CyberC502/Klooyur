package com.umn.kopicyber.klooyur.database

//
//@InstallIn(SingletonComponent::class)
//@Module
//object SupabaseModule {
//
//    @Provides
//    @Singleton
//    fun provideSupabaseClient(): SupabaseClient {
//        return createSupabaseClient(
//            supabaseUrl = BuildConfig.SUPABASE_URL,
//            supabaseKey = BuildConfig.SUPABASE_ANON_KEY
//        ) {
//            install(Postgrest)
//            install(Auth) {
//                flowType = FlowType.PKCE
//                scheme = "app"
//                host = "supabase.com"
//            }
//            install(Storage)
//        }
//    }
//
//    @Provides
//    @Singleton
//    fun provideSupabaseDatabase(client: SupabaseClient): Postgrest {
//        return client.postgrest
//    }
//
//    @Provides
//    @Singleton
//    fun provideSupabaseAuth(client: SupabaseClient): Auth {
//        return client.auth
//    }
//
//
//    @Provides
//    @Singleton
//    fun provideSupabaseStorage(client: SupabaseClient): Storage {
//        return client.storage
//    }
//
//}
