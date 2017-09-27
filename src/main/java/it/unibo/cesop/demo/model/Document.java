package it.unibo.cesop.demo.model;

import org.apache.solr.client.solrj.beans.Field;

import java.util.List;

public class Document {

    @Field("id")
    private String id;

    @Field("Nome")
    private String nome;

    @Field("Cognome")
    private String cognome;

    @Field("Eta")
    private int eta;

    @Field("Sesso")
    private String sesso;

    @Field("DomicilioComune")
    private String domicilioComune;

    @Field("DomicilioIndirizzo")
    private String domicilioIndirizzo;

    @Field("TitoliStudio")
    private List<String> titoliStudio;

    @Field("Competenze")
    private List<String> competenze;

    @Field("Competenze_label_t")
    private List<String> competenzeLabels;

    @Field("Competenze_parent_uris_s")
    private List<String> competenzeParents;

    @Field("Competenze_parent_labels_t")
    private List<String> competenzeParentsLabels;

    @Field("Competenze_ancestors_uris_s")
    private List<String> competenzeAncestors;

    @Field("Competenze_ancestors_labels_t")
    private List<String> competenzeAncestorsLabels;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getDomicilioComune() {
        return domicilioComune;
    }

    public void setDomicilioComune(String domicilioComune) {
        this.domicilioComune = domicilioComune;
    }

    public String getDomicilioIndirizzo() {
        return domicilioIndirizzo;
    }

    public void setDomicilioIndirizzo(String domicilioIndirizzo) {
        this.domicilioIndirizzo = domicilioIndirizzo;
    }

    public List<String> getTitoliStudio() {
        return titoliStudio;
    }

    public void setTitoliStudio(List<String> titoliStudio) {
        this.titoliStudio = titoliStudio;
    }

    public List<String> getCompetenze() {
        return competenze;
    }

    public void setCompetenze(List<String> competenze) {
        this.competenze = competenze;
    }

    public List<String> getCompetenzeLabels() {
        return competenzeLabels;
    }

    public void setCompetenzeLabels(List<String> competenzeLabels) {
        this.competenzeLabels = competenzeLabels;
    }

    public List<String> getCompetenzeParents() {
        return competenzeParents;
    }

    public void setCompetenzeParents(List<String> competenzeParents) {
        this.competenzeParents = competenzeParents;
    }

    public List<String> getCompetenzeParentsLabels() {
        return competenzeParentsLabels;
    }

    public void setCompetenzeParentsLabels(List<String> competenzeParentsLabels) {
        this.competenzeParentsLabels = competenzeParentsLabels;
    }

    public List<String> getCompetenzeAncestors() {
        return competenzeAncestors;
    }

    public void setCompetenzeAncestors(List<String> competenzeAncestors) {
        this.competenzeAncestors = competenzeAncestors;
    }

    public List<String> getCompetenzeAncestorsLabels() {
        return competenzeAncestorsLabels;
    }

    public void setCompetenzeAncestorsLabels(List<String> competenzeAncestorsLabels) {
        this.competenzeAncestorsLabels = competenzeAncestorsLabels;
    }
}
