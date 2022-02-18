<?xml version="1.0" encoding="ISO-8859-1" standalone="no"?> 
<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN" 
"http://java.sun.com/products/javahelp/helpset_2_0.dtd"> 
<helpset version="2.0"> 
    <title>Uso de Java Help</title> 
    <maps> 
        <homeID>clientes</homeID> 
        <mapref location="map.jhm"/> 
    </maps> 
    
    <view xml:lang="es" mergetype="javax.help.UniteAppendMerge"> 
        <name>TOC</name> 
        <label>Tabla de contenidos</label> 
        <type>javax.help.TOCView</type> 
        <data>TOC.xml</data> 
    </view> 
    
    <view xml:lang="es" mergetype="javax.help.SortMerge"> 
        <name>Index</name> 
        <label>Indice</label> 
        <type>javax.help.IndexView</type> 
        <data>index.xml</data> 
    </view> 
    
    <view xml:lang="es"> 
    <name>Buscar</name> 
    <label>Buscar</label> 
    <type>javax.help.SearchView</type> 
    <data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data> 
    </view> 
    
<!-- A glossary navigator --> 
<!--
<view mergetype="javax.help.SortMerge"> 
    <name>glosario</name> 
    <label>Glosario</label> 
    <type>javax.help.GlossaryView</type> 
    <data>glosario.xml</data> 
</view>
-->
<!-- A favorites navigator --> 
<!-- <view>--> 
<!-- <name>favoritos</name> --> 
<!-- <label>Favoritos</label> --> 
<!-- <type>javax.help.FavoritesView</type> --> 
<!-- </view>-->

<!-- presentation windows -->
<!-- This window is the default one for the helpset. 
    * Its title bar says "Project X Help". It 
    * is a tri-paned window because displayviews, not 
    * defined, defaults to true and because a toolbar is defined. 
    * The toolbar has a back arrow, a forward arrow, and 
    * a home button that has a user-defined image. --> 
    <!--
    <presentation default=true> 
        <name>Ventana principal</name> 
        <size width="400" height="400" /> 
        <location x="200" y="200" /> 
        <title>Visor de Ayuda</title> 
        <toolbar> 
            <helpaction>javax.help.BackAction</helpaction> 
            <helpaction>javax.help.ForwardAction</helpaction> 
            <helpaction image="logo">javax.help.HomeAction</helpaction> 
        </toolbar> 
    </presentation>
    -->
</helpset>