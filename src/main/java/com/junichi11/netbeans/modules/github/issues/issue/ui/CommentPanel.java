/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2014 Sun Microsystems, Inc.
 */
package com.junichi11.netbeans.modules.github.issues.issue.ui;

import com.junichi11.netbeans.modules.github.issues.utils.DateUtils;
import com.junichi11.netbeans.modules.github.issues.utils.UiUtils;
import java.awt.Font;
import java.util.Date;
import javax.swing.Icon;
import org.eclipse.egit.github.core.Comment;
import org.openide.util.NbBundle;

/**
 *
 * @author junichi11
 */
public class CommentPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = -1191208334240462498L;
    private static final String HTML_MIME_TYPE = "text/html"; // NOI18N
    private static final String PLAIN_MIME_TYPE = "text/plain"; // NOI18N

    private Comment comment;
    private boolean isQuote;
    private boolean isEdited;
    private boolean isDeleted;

    /**
     * Creates new form CommentPanel
     */
    private CommentPanel() {
        initComponents();
    }

    public CommentPanel(Comment comment, Icon icon) {
        this.comment = comment;
        initComponents();
        init();
        load(icon);
    }

    private void init() {
        // set monospaced font
        Font contentFont = contentTextPane.getFont();
        contentTextPane.setFont(new Font(Font.MONOSPACED, contentFont.getStyle(), contentFont.getSize()));

        previewLinkButton.setText(Bundle.CommentPanel_previewLinkButton_title_html());
    }

    final void load(Icon icon) {
        if (comment != null) {
            setUserName(comment.getUser().getLogin());
            setUserIcon(icon);
            setCreatedDate(comment.getCreatedAt());
            setUpdatedDate(comment.getUpdatedAt());
            setContent(comment.getBody());
        }
    }

    private void setUserName(String name) {
        userLinkButton.setText(name);
    }

    private void setUserIcon(Icon icon) {
        userLinkButton.setIcon(icon);
    }

    private void setCreatedDate(Date date) {
        if (date != null) {
            createdDateLabel.setText(DateUtils.DEFAULT_DATE_TIME_FORMAT.format(date));
        }
    }

    private void setUpdatedDate(Date date) {
        if (date != null) {
            updatedDateLabel.setText(DateUtils.DEFAULT_DATE_TIME_FORMAT.format(date));
        }
    }

    private void setContent(String content) {
        if (content == null) {
            contentTextPane.setText(""); // NOI18N
        } else if (content.isEmpty()) {
            contentTextPane.setText(""); // NOI18N
        } else {
            contentTextPane.setText(content); // NOI18N
        }
    }

    public Comment getComment() {
        return comment;
    }

    public String getSelectedText() {
        return contentTextPane.getSelectedText();
    }

    public boolean isQuote() {
        return isQuote;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setQuoteEnabled(boolean isEnabled) {
        quoteLinkButton.setEnabled(isEnabled);
    }

    public void setEditEnabled(boolean isEnabled) {
        editLinkButton.setEnabled(isEnabled);
    }

    public void setDeleteEnabled(boolean isEnabled) {
        deleteLinkButton.setEnabled(isEnabled);
    }

    void resetProperties() {
        isQuote = false;
        isEdited = false;
        isDeleted = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createdLabel = new javax.swing.JLabel();
        createdDateLabel = new javax.swing.JLabel();
        updatedLabel = new javax.swing.JLabel();
        updatedDateLabel = new javax.swing.JLabel();
        userLinkButton = new org.netbeans.modules.bugtracking.commons.LinkButton();
        editLinkButton = new org.netbeans.modules.bugtracking.commons.LinkButton();
        jSeparator1 = new javax.swing.JSeparator();
        contentTextPane = new javax.swing.JTextPane();
        quoteLinkButton = new org.netbeans.modules.bugtracking.commons.LinkButton();
        deleteLinkButton = new org.netbeans.modules.bugtracking.commons.LinkButton();
        previewLinkButton = new org.netbeans.modules.bugtracking.commons.LinkButton();

        org.openide.awt.Mnemonics.setLocalizedText(createdLabel, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.createdLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createdDateLabel, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.createdDateLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(updatedLabel, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.updatedLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(updatedDateLabel, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.updatedDateLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(userLinkButton, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.userLinkButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(editLinkButton, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.editLinkButton.text")); // NOI18N
        editLinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLinkButtonActionPerformed(evt);
            }
        });

        contentTextPane.setEditable(false);
        contentTextPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5));

        org.openide.awt.Mnemonics.setLocalizedText(quoteLinkButton, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.quoteLinkButton.text")); // NOI18N
        quoteLinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quoteLinkButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteLinkButton, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.deleteLinkButton.text")); // NOI18N
        deleteLinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLinkButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(previewLinkButton, org.openide.util.NbBundle.getMessage(CommentPanel.class, "CommentPanel.previewLinkButton.text")); // NOI18N
        previewLinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewLinkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentTextPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(userLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(createdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createdDateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(updatedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatedDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quoteLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdLabel)
                    .addComponent(createdDateLabel)
                    .addComponent(updatedLabel)
                    .addComponent(updatedDateLabel)
                    .addComponent(userLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quoteLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previewLinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quoteLinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quoteLinkButtonActionPerformed
        isQuote = true;
        firePropertyChange(CommentsPanel.PROP_COMMENT_QUOTE, null, null);
    }//GEN-LAST:event_quoteLinkButtonActionPerformed

    @NbBundle.Messages({
        "CommentPanel.message.delete.issue=Do you really want to delete this comment?"
    })
    private void deleteLinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLinkButtonActionPerformed
        if (!UiUtils.showQuestionDialog(Bundle.CommentPanel_message_delete_issue())) {
            return;
        }
        isDeleted = true;
        firePropertyChange(CommentsPanel.PROP_COMMENT_DELETED, null, null);
    }//GEN-LAST:event_deleteLinkButtonActionPerformed

    private void editLinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLinkButtonActionPerformed
        isEdited = true;
        firePropertyChange(CommentsPanel.PROP_COMMENT_EDITED, null, null);
    }//GEN-LAST:event_editLinkButtonActionPerformed

    @NbBundle.Messages({
        "CommentPanel.previewLinkButton.title.html=HTML",
        "CommentPanel.previewLinkButton.title.plain=Plain"
    })
    private void previewLinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewLinkButtonActionPerformed
        String text = previewLinkButton.getText();
        if (text.equals(Bundle.CommentPanel_previewLinkButton_title_html())) {
            previewLinkButton.setText(Bundle.CommentPanel_previewLinkButton_title_plain());
        } else {
            previewLinkButton.setText(Bundle.CommentPanel_previewLinkButton_title_html());
        }

        String contentType = contentTextPane.getContentType();
        if (contentType.equals(HTML_MIME_TYPE)) {
            contentTextPane.setContentType(PLAIN_MIME_TYPE);
            contentTextPane.setText(comment.getBody());
            return;
        }
        contentTextPane.setContentType(HTML_MIME_TYPE);
        contentTextPane.setText(comment.getBodyHtml());
    }//GEN-LAST:event_previewLinkButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane contentTextPane;
    private javax.swing.JLabel createdDateLabel;
    private javax.swing.JLabel createdLabel;
    private org.netbeans.modules.bugtracking.commons.LinkButton deleteLinkButton;
    private org.netbeans.modules.bugtracking.commons.LinkButton editLinkButton;
    private javax.swing.JSeparator jSeparator1;
    private org.netbeans.modules.bugtracking.commons.LinkButton previewLinkButton;
    private org.netbeans.modules.bugtracking.commons.LinkButton quoteLinkButton;
    private javax.swing.JLabel updatedDateLabel;
    private javax.swing.JLabel updatedLabel;
    private org.netbeans.modules.bugtracking.commons.LinkButton userLinkButton;
    // End of variables declaration//GEN-END:variables
}
